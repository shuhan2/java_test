package com.cultivation.javaBasicExtended.simpleMvc3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
abstract class Route {
    private final Class<? extends Controller> controllerClazz;
    private final String actionName;

    Route(Class<? extends Controller> controllerClazz, String actionName) {

        this.controllerClazz = controllerClazz;
        this.actionName = actionName;
    }

    public Class<? extends Controller> getControllerClass() { return controllerClazz; }
    public String getActionName() { return actionName; }

    public abstract boolean isMatch(String segment);
}

class RegexRoute extends Route {
    private final Pattern compiledPattern;

    RegexRoute(String pattern, Class<? extends Controller> controllerClazz, String actionName) {
        super(controllerClazz, actionName);
        compiledPattern = Pattern.compile(pattern);
    }

    @Override
    public boolean isMatch(String segment) {
        // TODO: please implement the following method to pass the test
        // <--start
        if (segment == null) return false;
        Matcher matcher = compiledPattern.matcher(segment);
        return matcher.matches();
        // --end-->
    }
}