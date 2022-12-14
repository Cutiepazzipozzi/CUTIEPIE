package jpa.practice.order;

import jpa.practice.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class OrderRepository {

    private final EntityManager em;

    public void join(Order order) {
        em.merge(order);
    }

    public Order findId(String id) {
        return em.find(Order.class, id);
    }

    public List findAll() {
        return em.createQuery("select o from Order as o")
                .getResultList();
    }

    public List<Order> memberOrderList(String id) {
        return em.createQuery("select o from Order o where o.memberId = :member_id", Order.class)
                .setParameter("member_id", id)
                .getResultList();
    }

    public void delete(Order order) {
        em.remove(order);
    }
}
