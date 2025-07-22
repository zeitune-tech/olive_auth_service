package sn.zeitune.oliveinsuranceauthservice.app.repositories;

import io.netty.resolver.dns.DnsServerAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.zeitune.oliveinsuranceauthservice.app.entities.Contributor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContributorRepository extends JpaRepository<Contributor, Long>, JpaSpecificationExecutor<Contributor> {

    Optional<Contributor> findByUuid(UUID uuid);
    List<Contributor> findByManagementEntity(UUID managementEntity);

}
