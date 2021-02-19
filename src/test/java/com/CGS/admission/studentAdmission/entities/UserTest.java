package com.CGS.admission.studentAdmission.entities;

import com.CGS.admission.studentAdmission.testUtil.TestUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
private User user=new User();

@Test
public void gettersAndSettersTest(){

    user.setId(TestUtil.generateRandomLong());
    user.setEmail(TestUtil.generateRandomString());
    user.setFirstName(TestUtil.generateRandomString());
    user.setLastName(TestUtil.generateRandomString());
    user.setPassword(TestUtil.generateRandomString());
    user.setRoles(Stream.of(new Role("Adming")).collect(Collectors.toList()));
    user.setEnabled(true);

    assertNotNull(user.getId());
    assertNotNull(user.getEmail());
    assertNotNull(user.getFirstName());
    assertNotNull(user.getLastName());
    assertNotNull(user.getPassword());
    assertNotNull(user.getRoles());
    assertEquals(user.isEnabled(),true);
}

}