package com.example.cachedconsumer.model;

import com.example.cachedconsumer.model.User;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name="List")
@XmlAccessorType(XmlAccessType.NONE)

public class CollectionUserDto implements Serializable {
    @XmlElement(name="item")
    private List<User> userList;
}
