package com.dna.api;

import com.dna.entity.Puppy;
import com.dna.service.RegisterService;
import com.dna.util.SerializeUtil;
import com.dna.util.StorageUtil;
import com.google.gson.Gson;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peng on 18/3/9.
 */
@Path("trade")
public class Trade {
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    RegisterService registerService;

    @POST
    @Path("register/{name}/{breed}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@FormParam("name") @NotNull String name, @FormParam("breed") @NotNull String breed,
                           @FormParam("breeder") @NotNull String breeder, @FormParam("gender") @NotNull int gender,
                           @FormParam("birthday") @NotNull String birthday, @FormParam("color") @NotNull String color,
                           @FormParam("certiNo") @NotNull String certiNo, @FormParam("remark") @NotNull String remark,
                           @FormParam("ownerCertiNo") @NotNull String ownerCertiNo, @FormParam("ownerCertiType") @NotNull String ownerCertiType,
                           @FormParam("ownerName") @NotNull String ownerName, @FormParam("snp") @NotNull String snp) {

        com.dna.entity.Response response = new com.dna.entity.Response();
        Gson gson = new Gson();
        Puppy puppy = new Puppy();

        puppy.setName(name);
        puppy.setBirthday(LocalDateTime.parse(birthday,df));
        puppy.setBreed(breed);
        puppy.setBreeder(breeder);
        puppy.setCertiNo(certiNo);
        puppy.setColor(color);
        puppy.setGender(gender);
        puppy.setRemark(remark);
        puppy.setOwnerName(ownerName);
        puppy.setOwnerCertiNo(ownerCertiNo);
        puppy.setOwnerCertiType(ownerCertiType);

        List<String> snpList = Arrays.asList(snp.split(","));
        puppy.setSnp(snpList);

        if(registerService.register(puppy)) {
            response.setResponse_code("000000");
            response.setError_desc("succeed");
        }

        return gson.toJson(response);
    }

    @DELETE
    @Path("delete")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("id") @javax.validation.constraints.NotNull String id) {
        com.dna.entity.Response response = new com.dna.entity.Response();
        Gson gson = new Gson();

        if(StorageUtil.delete(id)){
            response.setResponse_code("000000");
            response.setError_desc("succeed");
        }
        return gson.toJson(response);
    }

    @PUT
    @Path("put")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public String transfer(@FormParam("id") @javax.validation.constraints.NotNull String id, @FormParam("ownerCertiNo") @javax.validation.constraints.NotNull String ownerCertiNo, @FormParam("ownerCertiType") @javax.validation.constraints.NotNull String ownerCertiType, @FormParam("ownerName") String ownerName) {
        com.dna.entity.Response response = new com.dna.entity.Response();
        Gson gson = new Gson();
        Puppy puppy;

        byte[] para = StorageUtil.get(id);
        Object obj = SerializeUtil.toObject(para);
        if(obj != null){
            puppy = (Puppy) obj;
            puppy.setOwnerCertiNo(ownerCertiNo);
            puppy.setOwnerCertiType(ownerCertiType);
            puppy.setOwnerName(ownerName);
            para = SerializeUtil.toByteArray(puppy);
            if(para != null) {
                if (StorageUtil.transfer(id, para)) {
                    response.setResponse_code("000000");
                    response.setError_desc("succeed");
                }
            }
        }
        return gson.toJson(response);
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") String id) {
        com.dna.entity.Response response = new com.dna.entity.Response();
        Gson gson = new Gson();
        Puppy puppy;

        byte[] para = StorageUtil.get(id);
        Object obj = SerializeUtil.toObject(para);
        if (obj != null) {
            puppy = (Puppy) obj;
            return gson.toJson(puppy);
        }
        return null;
    }
}
