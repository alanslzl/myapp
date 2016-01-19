package com.myapp.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameworkException extends Exception
{
    /**
     * 服务器内部错误
     */
    public static final String ERROR_CODE_SYSTEM_RRROR = "framework-000";
    
    /**
     * 异常编码
     */
    protected String errorCode = null;
    
    private static final Logger log = LoggerFactory.getLogger(FrameworkException.class);
    
    private static final long serialVersionUID = -5957059410743041631L;
    

    public FrameworkException()
    {
        super();
        this.errorCode = FrameworkException.ERROR_CODE_SYSTEM_RRROR;
    }

    public FrameworkException(Exception ex)
    {
        super(FrameworkException.ERROR_CODE_SYSTEM_RRROR, ex);
    }

    public FrameworkException(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public FrameworkException(String errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public FrameworkException(String errorCode, String message, Throwable cause)
    {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public FrameworkException(String errorCode, Throwable cause)
    {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode()
    {
        return this.errorCode;
    }

    public void logError()
    {
        this.printStackTrace();
        StackTraceElement source = this.getStackTrace()[0];
        String sourceMethod = source.getClassName() + "." + source.getMethodName();
        FrameworkException.log.error("信息源方法：" + sourceMethod, this.getCause());
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
}
