package com.roadtomaster.financialAsset.infrastructure.persistence.account;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import lombok.Data;


import java.util.UUID;

@Data
public class AccountQuery {

  private UUID id;

  private Double balance;

  private String ownerId;

  public BooleanExpression toPredicate(){
    var qAccount = QAccountTable.accountTable;
    var predicate = Expressions.asBoolean(true).isTrue();

    if(id != null){
      predicate.or(qAccount.id.eq(id));
    }
    if(ownerId != null){
      predicate.or(qAccount.ownerId.eq(ownerId));
    }
    if(balance != null){
      predicate.or(qAccount.balance.lt(balance));
    }

    return predicate;
  }
}
