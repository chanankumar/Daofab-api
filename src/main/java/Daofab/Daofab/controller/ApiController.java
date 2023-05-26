package Daofab.Daofab.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Daofab.Daofab.childcontroller.Child;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;

@RestController
public class ApiController  {

	private static final int DEFAULT_PAGE_SIZE = 10;

    @GetMapping("/ParentData")
    public List<Parent> getParentData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "" + DEFAULT_PAGE_SIZE) int size,
            @RequestParam(value = "sort", defaultValue = "asc") String sort) throws IOException {

        List<Parent> allUsers = getAllParentDataFromJson();
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, allUsers.size());
        List<Parent> paginatedUsers = allUsers.subList(startIndex, endIndex);

        if (sort.equalsIgnoreCase("asc")) {
            paginatedUsers.sort(Comparator.comparing(Parent::getId));
        } else if (sort.equalsIgnoreCase("desc")) {
            paginatedUsers.sort(Comparator.comparing(Parent::getId).reversed());
        }
        
        return paginatedUsers;
	}
    
   
	
    private List<Parent> getAllParentDataFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("Parent.json");

        return objectMapper.readValue(inputStream, new TypeReference<List<Parent>>() {});
    }

}
