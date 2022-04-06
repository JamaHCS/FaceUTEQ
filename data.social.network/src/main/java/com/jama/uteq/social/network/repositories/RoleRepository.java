package com.jama.uteq.social.network.repositories;

import com.jama.uteq.social.network.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role getRoleByName(String name);
}
