package com.example.webfluxWithAws.controller;

import com.example.webfluxWithAws.domain.AWSDb;
import com.example.webfluxWithAws.repo.AwsDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
public class TestController {

    @Autowired
    private AwsDBRepo awsDBRepo;


    @RequestMapping("/hello")
    public Mono<AWSDb> hello(@RequestBody String jsonData) {
        AWSDb awsDb = new AWSDb();
        awsDb.setJsonData(jsonData);
        //awsDBRepo.save(awsDb);

        return Mono.just(awsDb);
    }


    @RequestMapping("/testMono")
    public Mono<AWSDb> testMono(){
        String[] ids = new String[] {"12333", "55668b40-c994-48dd-af0d-2e24820d00dd", "b46234ef-16a8-4b51-b073-b15a16f3a619"};

        return Mono.just(awsDBRepo.getById(ids[0]));
    }

    @RequestMapping(value = "/testFlux")
    public Flux<String> testFluxII(){
        String[] ids = new String[] {"12333", "55668b40-c994-48dd-af0d-2e24820d00dd", "b46234ef-16a8-4b51-b073-b15a16f3a619"};

        return Flux.fromStream(IntStream.range(0, 3).mapToObj(I -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "flux data—" + awsDBRepo.getById(ids[I]);
        }));
    }

    @RequestMapping("testFluxSub")
    public Flux<Stream> testFluxSub(@RequestBody String str){
        Stream stream = IntStream.range(0,20).mapToObj(I -> {
            return str;
        });

        return Flux.just(stream);
    }

}
