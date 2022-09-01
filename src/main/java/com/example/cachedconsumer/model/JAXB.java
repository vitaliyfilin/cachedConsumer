package com.example.cachedconsumer.model;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class JAXB {

    public static void main(String[] args) throws JAXBException {
        Student student = new Student();
        student.setAge(25);
        student.setName("Some Kid");
        Balance balance = new Balance();
        balance.setValue(1000);
        balance.setId(1L);
        User user = new User();
        user.setId(1L);
        user.setBalance(balance);
        CollectionUserDto collectionUserDto = new CollectionUserDto();
        List<User> userList = new ArrayList<>();
        userList.add(user);
        collectionUserDto.setUserList(userList);
        //System.out.println(deserialize(serialize(collectionUserDto)));
    }


    public static final String serialize(CollectionUserDto student) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(CollectionUserDto.class);
        Marshaller m = context.createMarshaller();
        m.marshal(student, writer);
        return writer.toString();
    }


    public static final CollectionUserDto deserialize(String input) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CollectionUserDto.class);
        Unmarshaller m = context.createUnmarshaller();
        return (CollectionUserDto) m.unmarshal(new StringReader(input));
    }

    @XmlRootElement(name="student")
    @XmlAccessorType(XmlAccessType.NONE)
    static class Student {
        @XmlElement(name="name")
        private String name;
        @XmlElement(name="age")
        private int age;

        public Student() {
        }

        public void setName(String name) { this.name = name; }
        public String getName() { return name; }
        public void setAge(int age) { this.age = age; }
        public int getAge() { return age; }
    }
}