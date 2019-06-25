//package com.gupb.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RateLimiter {
//
//    /**
//     * 根据Hostname进行限流
//     *
//     * @return
//     */
//    @Bean
//    public HostAddrKeyResolver hostAddrKeyResolver() {
//        return new HostAddrKeyResolver();
//    }
//
////    /**
////     * 根据uri去限流
////     *
////     * @return
////     */
////    @Bean
////    public UriKeyResolver uriKeyResolver() {
////        return new UriKeyResolver();
////    }
////
////    /**
////     * 根据用户的维度去限流
////     *
////     * @return
////     */
////    @Bean
////    public UserKeyResolver userKeyResolver() {
////        return new UserKeyResolver();
////    }
//}
