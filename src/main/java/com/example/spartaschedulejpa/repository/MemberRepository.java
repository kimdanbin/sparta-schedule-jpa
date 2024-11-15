package com.example.spartaschedulejpa.repository;

import com.example.spartaschedulejpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);
    Optional<Member> findIdByEmailAndPassword(String email, String password);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }

    default Member findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    default Member findIdByEmailAndPasswordOrElseThrow(String email, String password) {
        return findIdByEmailAndPassword(email, password).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist email = " + email));
    }


}