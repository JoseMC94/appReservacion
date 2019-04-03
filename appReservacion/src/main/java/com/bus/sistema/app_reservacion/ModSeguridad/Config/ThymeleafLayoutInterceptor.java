package com.bus.sistema.app_reservacion.ModSeguridad.Config;

import com.bus.sistema.app_reservacion.ModSeguridad.Controller.LoginController;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.MenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.RolMenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRolRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl.UserServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {
    private static final String DEFAULT_LAYOUT = "layouts/layout";
    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }
        String originalViewName = modelAndView.getViewName();
        if (isRedirectOrForward(originalViewName)) {
            return;
        }
        String layoutName = getLayoutName(handler);
        modelAndView.setViewName(layoutName);
        modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalViewName);


            if (!SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("anonymousUser")) {
                WebApplicationContext applicationContext = RequestContextUtils.getWebApplicationContext(request);
                UserServiceImpl userService = (UserServiceImpl) ((WebApplicationContext) applicationContext).getBean("userServiceEImpl");
                UserRolRepository userRolRepository = (UserRolRepository) ((WebApplicationContext) applicationContext).getBean("userRolRepository");
                RolMenuRepository rolMenuRepository = (RolMenuRepository) ((WebApplicationContext) applicationContext).getBean("rolMenuRepository");
                MenuRepository menuRepository = (MenuRepository) ((WebApplicationContext) applicationContext).getBean("menuRepository");
                User user = userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName());
                List<RolMenu> listRolMenu = rolMenuRepository.findAllByRolId(userRolRepository.findByUsuarioId(userService.findOne(user.getUsername()).getUsuarioId()).getRolId());
                List<Menu> listMenu = menuRepository.findAll();
                ArrayList<Menu> listaMenuUsuario = new ArrayList<>();
                listRolMenu.forEach(rolMenu -> listMenu.stream().filter(menu -> rolMenu.getMenuId() == menu.getMenuId()).forEach(listaMenuUsuario::add));
                modelAndView.addObject("menus", listMenu);
                modelAndView.addObject("menus2", listMenu);
                modelAndView.addObject("usuarioConectado", userService.findOne(user.getUsername()).getPersonaByPersonaId().getNombres() + " " + userService.findOne(user.getUsername()).getPersonaByPersonaId().getPaterno());
            }



    }

    private boolean isRedirectOrForward(String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }


    private String getLayoutName(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginController.Layout layout = handlerMethod.getMethodAnnotation(LoginController.Layout.class);
        if (layout == null) {
            return DEFAULT_LAYOUT;
        } else {
            return layout.value();
        }
    }
}
