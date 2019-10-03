package hu.flowacademy.kingmakerbackend.repository;

import hu.flowacademy.kingmakerbackend.model.crew.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrewRepository extends JpaRepository<Member, Long> {
}
