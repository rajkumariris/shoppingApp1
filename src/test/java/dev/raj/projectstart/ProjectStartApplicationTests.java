package dev.raj.projectstart;

import dev.raj.projectstart.inheritanceexamples.joinedtable.JTMentorRepository;
import dev.raj.projectstart.inheritanceexamples.joinedtable.JTUserRespository;
import dev.raj.projectstart.inheritanceexamples.joinedtable.Mentor;
import dev.raj.projectstart.inheritanceexamples.joinedtable.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectStartApplicationTests {
    @Autowired
    private JTUserRespository userRespository;
    @Autowired
    private JTMentorRepository MSMentorRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testDifferentInheritances(){
        User user = new User();
        user.setEmail("raj@scaler.com");
        user.setPassword("123456");
        userRespository.save(user);


        Mentor ment = new Mentor();
        ment.setEmail("raj123@ssclaer.com");
        ment.setPassword("paswrd");
        ment.setNoOfMentees(4);
        ment.setNoofSessions(6);
        MSMentorRepository.save(ment);

    }


}
