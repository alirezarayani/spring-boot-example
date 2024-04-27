package ir.lazydeveloper.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        // Customize error attributes here
//        errorAttributes.remove("timestamp"); // Remove timestamp
//        errorAttributes.remove("path"); // Remove request path
//        errorAttributes.put("test", 1234);
        return errorAttributes;
    }
}
