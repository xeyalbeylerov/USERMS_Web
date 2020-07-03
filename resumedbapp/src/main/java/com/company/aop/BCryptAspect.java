package com.company.aop;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect

public class BCryptAspect {

    //User password hasher
    @Pointcut("execution(* com.company.dao.impl.UserDaoImpl.*(com.company.entity.User))")
    private void passwordHasher() {
    }

    @Around("passwordHasher()")
    public Object passwordEncoderAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args.length > 0) {
            User u = (User) args[0];
            String password = u.getPassword();
            u.setPassword(getHash(password));
            args[0] = u;
        }
        Object result = proceedingJoinPoint.proceed(args);
        return result;
    }

//    User password verifier
    @Pointcut("execution(* com.company.dao.impl.UserDaoImpl.getVerify(..))")
    private void passwordVerifier() {
    }

    @Around("passwordVerifier()")
    public Object passwordVerifierAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        boolean isVerify = false;
        if (args.length > 1) {
            String password = (String) args[0];
            String hash = (String) args[1];
            isVerify = getVerify(password, hash);
        }
        Object result = isVerify;
        return result;
    }

//    BCrypt Hasher and Verifier
    private String getHash(String password) {
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        String saltedPassword = password;
        return crypt.hashToString(4, saltedPassword.toCharArray());
    }

    private boolean getVerify(String password, String hash) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result verify = verifyer.verify(password.toCharArray(), hash.toCharArray());
        return verify.verified;
    }
}
