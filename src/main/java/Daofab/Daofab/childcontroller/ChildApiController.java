package Daofab.Daofab.childcontroller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ChildData")
public class ChildApiController {

    @GetMapping("/{id}")
    public List<Child> getUsersById(@PathVariable int id) {
    	List<Child> allUsers = getAllUsersFromJson();
        return allUsers.stream()
                .filter(data -> data.getParentId() == id)
                .collect(Collectors.toList());
    }

    private List<Child> getAllUsersFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("Child.json");

        try {
            return objectMapper.readValue(inputStream, new TypeReference<List<Child>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
