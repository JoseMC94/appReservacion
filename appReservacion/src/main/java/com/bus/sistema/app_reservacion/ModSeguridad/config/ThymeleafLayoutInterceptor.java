package com.bus.sistema.app_reservacion.ModSeguridad.config;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.bus.sistema.app_reservacion.ModSeguridad.Controller.LoginController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThymeleafLayoutInterceptor  extends HandlerInterceptorAdapter{
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
