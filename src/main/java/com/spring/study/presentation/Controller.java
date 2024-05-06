package com.spring.study.presentation;

import com.spring.study.data.vo.MemberRequestVo;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping("/request1")
    public String getRequestParam1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(
        @RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberRequestVo memberRequestVo) {
        return memberRequestVo.toString();
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberRequestVo memberRequestVo) {
        return memberRequestVo.toString();
    }
}
