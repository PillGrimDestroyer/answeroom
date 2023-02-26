package com.example.answeroom.exception;


import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ErrStackTrace {
    public String        message;
    public String        className;
    public String        errorType;
    public List<String>  stackTrace = new ArrayList<>();
    public ErrStackTrace cause;

    public static ErrStackTrace from(Throwable error) {
        return from(error, false);
    }

    public static ErrStackTrace from(Throwable error, boolean isHideStackTrace) {
        if (error == null) {
            return null;
        }

        ErrStackTrace ret = new ErrStackTrace();
        ret.message = error.getMessage();
        ret.className = error.getClass().getName();
        ret.errorType = error.getClass().getSimpleName();

        if (!isHideStackTrace) {
            for (final StackTraceElement ste : error.getStackTrace()) {
                StringBuilder sb         = new StringBuilder();
                var           moduleName = ste.getModuleName();
                if (moduleName != null) {
                    sb.append(moduleName).append('/');
                }
                sb.append(ste.getClassName());
                sb.append('.');
                sb.append(ste.getMethodName());
                sb.append('(');
                sb.append(ste.getFileName()).append(':').append(ste.getLineNumber());
                sb.append(')');
                ret.stackTrace.add(sb.toString());
            }
        }

        ret.cause = from(error.getCause(), isHideStackTrace);

        return ret;
    }

    public String messageWithStacktrace() {
        StringBuilder sb = new StringBuilder();
        appendMessageWithStackTrace(sb);
        return sb.toString();
    }

    private void appendMessageWithStackTrace(StringBuilder sb) {
        sb.append(className).append(": ").append(message).append("\n");
        for (final String ste : stackTrace) {
            sb.append("  _at ").append(ste).append("\n");
        }

        var cause = this.cause;
        if (cause != null) {
            sb.append("Cause :");
            cause.appendMessageWithStackTrace(sb);
        }
    }
}

