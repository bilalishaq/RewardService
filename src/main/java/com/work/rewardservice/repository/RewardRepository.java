package com.work.rewardservice.repository;

import com.work.rewardservice.entity.Reward;
import com.work.rewardservice.entity.RewardData;
import com.work.rewardservice.model.RewardResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RewardRepository extends JpaRepository<Reward,Long> {

    @Query(value = "select  c.first_name as customerFirstName , sum(r.points_earned) as totalRewardPoints \n" +
                    "from reward r \n" +
                    "inner join order_detail od on r.id = od.reward_id\n" +
                    "inner join customer c on c.id = od.customer_id\n" +
                    "where od.order_date between :startDate and :endDate \n" +
                    "group by od.customer_id",
            nativeQuery = true)
    Collection<RewardData> findAllRewardPointsGroupByCustomer(String startDate, String endDate);


}
