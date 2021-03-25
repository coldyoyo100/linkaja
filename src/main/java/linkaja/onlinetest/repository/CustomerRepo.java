package linkaja.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import linkaja.onlinetest.model.CustomerModel;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>{

}
