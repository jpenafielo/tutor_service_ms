package com.api.tutor_service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
      }

      public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
      }

      public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super("%s not found with %s : '%s'".formatted(resourceName, fieldName, fieldValue));
    }
    
}
