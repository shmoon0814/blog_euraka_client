package m.s.h.blog_eureka_client.controller;


import io.swagger.annotations.*;
import m.s.h.blog_eureka_client.model.SampleModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Api(tags = " 샘플 및 테스트 주소")
@RestController
public class TestController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "value 값 아무거나 인트형", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "사업자번호", required = true, dataType = "int"),
    })
    @ApiOperation(value = "Api 리턴값 샘플입니다. 토큰 없이 호출이 가능합니다", notes = "리턴 형식 테스트 입니다. 참고해주세요.")
    @ApiResponses(@ApiResponse(code = 200, message = "OK", response = SampleModel.class))
    @GetMapping("/api/adviser/client/sampleApi")
    public ResponseEntity sampleApi(@RequestParam Integer value, @RequestParam String name){
        SampleModel sampleModel = new SampleModel();
        sampleModel.setValue(value);
        sampleModel.setName(name);
        return new ResponseEntity(sampleModel, HttpStatus.OK);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "value", value = "value 값 아무거나 인트형", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "사업자번호", required = true, dataType = "int")
    })
    @ApiOperation(value = "Api 리턴값 샘플입니다. 토큰 없이 호출이 가능합니다", notes = "리턴 형식 테스트 입니다. 참고해주세요. 리스트 형식입니다.")
    @ApiResponses(@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = SampleModel.class))
    @GetMapping("/api/adviser/client/sampleApi2")
    public ResponseEntity sampleApi2(@RequestParam Integer value, @RequestParam String name){
        List<SampleModel> list = new LinkedList<>();

        SampleModel sampleModel = new SampleModel();
        sampleModel.setValue(value);
        sampleModel.setName(name);
        list.add(sampleModel);

        sampleModel.setValue(value+1);
        list.add(sampleModel);

        sampleModel.setValue(value+2);
        list.add(sampleModel);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "authorization header", required = true, dataType = "string", paramType = "header", defaultValue = "bearer eyJ1c2VyVHlwZSI6IlVTRVIiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzY1NjMyNTgsImV4cCI6MTU3ODMxNjI5MSwiaXNzIjoibW93YV9hdXRoZW5jaWF0aW9uX3NlcnZlciJ9.ufRSIftrTW5qjS-eQJ_CRycaiPnynoJKIJrL433yt_g"),
            @ApiImplicitParam(name = "value", value = "value 값 아무거나 인트형", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "사업자번호", required = true, dataType = "int")
    })
    @ApiOperation(value = "Api 리턴값 샘플입니다. 토큰 있어야 호출 가능합니다", notes = "리턴 형식 테스트 입니다. 참고해주세요. 리스트 형식입니다.")
    @ApiResponses(@ApiResponse(code = 200, message = "OK", responseContainer = "List", response = SampleModel.class))
    @GetMapping("/api/adviser/client/sampleApi3")
    public ResponseEntity sampleApi3(@RequestParam Integer value, @RequestParam String name){
        List<SampleModel> list = new LinkedList<>();

        SampleModel sampleModel = new SampleModel();
        sampleModel.setValue(value);
        sampleModel.setName(name);
        list.add(sampleModel);

        sampleModel.setValue(value+1);
        list.add(sampleModel);

        sampleModel.setValue(value+2);
        list.add(sampleModel);

        return new ResponseEntity(list, HttpStatus.OK);
    }

}