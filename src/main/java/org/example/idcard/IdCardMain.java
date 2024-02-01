package org.example.idcard;

import org.example.idcard.model.entity.IdCard;
import org.example.idcard.repository.IdCardRepository;
import org.example.idcard.repository.impl.IdCardRepositoryImpl;

import java.util.List;

public class IdCardMain {

    public static void main(String[] args) {
        IdCardRepository idCardRepository = IdCardRepositoryImpl.getInstance();

//        List<IdCard> idCards = idCardRepository.getAll();
//        System.out.println("---------idCards-------------");
//        System.out.println(idCards);

//        IdCard shiraliIdCard = idCardRepository.getById(1L);
//        System.out.println("---------idCard Shirali-------------");
//        System.out.println(shiraliIdCard);

//        shiraliIdCard.setAge(24);
//        boolean update = idCardRepository.update(shiraliIdCard);
//        System.out.println("---------update-------------");
//        System.out.println(update);

//        IdCard newIdCard = IdCard.builder()
//                .name("Habil")
//                .surname("Aliyev")
//                .age(23)
//                .finCode("DFS9ADJ")
//                .series("AA")
//                .serialNumber("1231643")
//                .build();
//        boolean insert = idCardRepository.insert(newIdCard);
//        System.out.println("---------insert-------------");
//        System.out.println(insert);

        boolean delete = idCardRepository.delete(6L);
        System.out.println("---------delete-------------");
        System.out.println(delete);

    }

}
