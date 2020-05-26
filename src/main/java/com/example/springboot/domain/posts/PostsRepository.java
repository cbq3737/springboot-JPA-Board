package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//Posts클래스로 DataBase를 접근하게 해줄 JpaRepository, 여기가 Mybatis에서 Dao인 DB접근자임.
public interface PostsRepository extends JpaRepository<Posts,Long> {//이렇게 생성한 후에 <Entity클래스,PK타입>주면 알아서 CRUD메소드 자동생성됨 ,이때 Entity와 Repository는 같은 위치에 있어야한다.

}
