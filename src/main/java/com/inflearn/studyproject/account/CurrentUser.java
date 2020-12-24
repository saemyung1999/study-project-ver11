package com.inflearn.studyproject.account;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account")
//해당 사용자가 인증되지 않았으면 anonymousUser로 등록되어 null값이 들어가게 되고 인증되었다면 AccountService에서 등록한 Principal값인 UserAccount의 프로퍼티값인 account를 가져옴
public @interface CurrentUser {
}
