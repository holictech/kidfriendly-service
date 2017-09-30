package com.holictechnology.kidfriendly.mount.dto;


import java.util.ArrayList;
import java.util.List;

import com.holictechnology.kidfriendly.domain.dto.CompanyDto;
import com.holictechnology.kidfriendly.domain.dto.PhoneDto;
import com.holictechnology.kidfriendly.domain.entity.Address;
import com.holictechnology.kidfriendly.domain.entity.City;
import com.holictechnology.kidfriendly.domain.entity.Company;
import com.holictechnology.kidfriendly.domain.entity.Image;
import com.holictechnology.kidfriendly.domain.entity.Phone;
import com.holictechnology.kidfriendly.domain.enumerator.TypePhoneEnum;


/**
 * Class responsible for converte company entity and company dto
 * 
 * @author paulocotta
 *
 */
public class CompanyToCompanyDto {

    /**
     * Instance in class for access methods
     * 
     * @return
     */
    public static CompanyToCompanyDto getInstance() {
        return new CompanyToCompanyDto();
    }

    /**
     * Method in create object for persist
     * 
     * @param companyDto
     * @return
     */
    public Company companyDtoToCompany(CompanyDto companyDto) {
        Company company = new Company();

        company.setDesName(companyDto.getDesName());
        company.setIdCompany(companyDto.getIdCompany());
        company.setImgLogo(companyDto.getImgLogo());
        company.setNumRate(companyDto.getNumRate());
        company.setDesSite(companyDto.getDesSite());
        company.setDesCNPJ(companyDto.getDocument());
        company.setDesNameResponsible(companyDto.getNamePearsonResponsible());

        return company;
    }

    /**
     * Method create address for company
     * 
     * @param companyDto
     * @param city
     * @return
     */
    public Address mountAddress(CompanyDto companyDto, City city) {
        Address address = new Address();

        address.setCity(city);
        address.setDescCode(companyDto.getAddressDto().getDescCode());
        address.setDesComplement(companyDto.getAddressDto().getDesComplement());
        address.setDesNeighborhood(companyDto.getAddressDto().getDesNeighborhood());
        address.setDesStreet(companyDto.getAddressDto().getDesStreet());
        address.setNumLatitude(companyDto.getAddressDto().getNumLatitude());
        address.setNumLongitude(companyDto.getAddressDto().getNumLongitude());
        address.setNumStreet(companyDto.getAddressDto().getNumStreet());

        return address;
    }

    /**
     * Method in mount images catalog company
     * 
     * @param company
     * @param companyDto
     * @return
     */
    public List<Image> mountImageCompany(Company company, CompanyDto companyDto) {
        List<Image> imagens = new ArrayList<Image>();

        if (companyDto.getImageDtos() != null) {
            if (!companyDto.getImageDtos().isEmpty()) {
                for (int i = 0; i < companyDto.getImageDtos().size(); i++) {
                    Image image = new Image();
                    image.setCompany(company);
                    image.setDesImage(companyDto.getImageDtos().get(i).getDesImage());
                    image.setImgImage(companyDto.getImageDtos().get(i).getImgImage());
                    imagens.add(image);
                }
            }
        }

        return imagens;
    }

    /**
     * Method mount phones in company
     * 
     * @param companyDto
     * @param company
     * @return
     */
    public List<Phone> mountPhone(CompanyDto companyDto, Company company) {
        List<Phone> phones = new ArrayList<Phone>();

        if (companyDto.getPhoneDtos() != null) {
            if (!companyDto.getPhoneDtos().isEmpty()) {
                for (PhoneDto phoneDto : companyDto.getPhoneDtos()) {
                    Phone phone = new Phone();
                    phone.setCompany(company);
                    phone.setNumPhone(phoneDto.getNumPhone());
                    phoneDto.getTypePhoneEnum();
                    phone.setTypePhoneEnum(TypePhoneEnum.CELL_PHONE);

                    phones.add(phone);
                }
            }
        }

        return phones;
    }

}
