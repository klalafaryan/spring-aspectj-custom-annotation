package com.spring.annotation.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ValidateRequestAspect {

    @Around("@annotation(com.spring.annotation.example.ValidateRequest)")
    public Object validateActionRequest(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object joinPointResult;
        try {
            /*Check if method has argument with type AbstractRequestModel*/
            final AbstractRequestModel facadeActionModel = getActionRequest(joinPoint.getArgs());
            if (facadeActionModel != null) {
                /*Validate request model*/
                final List<String> errors = validateRequiredFields(facadeActionModel);
                if (errors.size() != 0) {
                    return new ResultModel<>(errors);
                }
            }
            joinPointResult = joinPoint.proceed();
        } catch (final Exception ex) {
            System.out.println(ex);
            throw ex;
        }
        return joinPointResult;
    }

    /**
     * @param args the args
     * @return the AbstractRequestModel
     */
    private static AbstractRequestModel getActionRequest(final Object[] args) {
        for (final Object arg : args) {
            if (arg instanceof AbstractRequestModel) {
                return (AbstractRequestModel) arg;
            }
        }
        return null;
    }

    /**
     * @param requestModel the request model
     * @return the list of error messages
     */
    private List<String> validateRequiredFields(final AbstractRequestModel requestModel) {
        final List<String> errors = new ArrayList<>();
        errors.addAll(requestModel.validateFields());
        return errors;
    }

}
