package in.sp.SpringBootRestfulWs.repositories;

import in.sp.SpringBootRestfulWs.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer>
{

}
