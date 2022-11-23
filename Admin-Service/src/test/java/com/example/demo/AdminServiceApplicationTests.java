package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.stream.Collectors;
import java.util.stream.Stream;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



import com.example.demo.entity.Customer;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AdminService;





@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceApplicationTests {




    @Autowired
    private AdminService adminService;



   @MockBean
    private UserRepository userRepository;




    //TEST GET USER
    
    @Test
    public void getUsersTest() {
        when(userRepository.findAll()).thenReturn(Stream.of(new Customer("Danile","466@12","USA12","danile123","3"), new Customer("Bob","789@","emma@123","emmaqwe","5")).collect(Collectors.toList()));
        assertEquals(2, adminService.getAllCustomers().size());
    }



   //TEST ADD USER
    
    @Test
    public void addUserTest() {
        Customer user = new Customer("Harry","678@pass","Harry@gmail.com","harry","2");
        when(userRepository.save(user)).thenReturn(user);
        assertThat(user).isEqualTo(adminService.addCustomer(user));
        
    }
    
    //TEST DELETE BY USER ID
    
    @Test
    public void deleteUserTest() {
        
        String id="123456";
        adminService.deleteCustomer(id);
        verify(userRepository, times(1)).deleteById(id);
    
}
}