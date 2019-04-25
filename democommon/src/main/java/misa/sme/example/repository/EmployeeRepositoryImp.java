package misa.sme.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import misa.sme.example.common.AbstractDaoImp;
import misa.sme.example.model.EmployeeEntity;

@Service
public class EmployeeRepositoryImp extends AbstractDaoImp<String, EmployeeEntity>  implements EmployeeRepository{


}
