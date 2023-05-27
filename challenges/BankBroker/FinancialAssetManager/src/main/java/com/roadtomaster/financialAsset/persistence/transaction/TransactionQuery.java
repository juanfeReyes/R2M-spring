package com.roadtomaster.financialAsset.persistence.transaction;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

public class TransactionQuery {

  public BooleanExpression queryByUser(String userId){
    var qTransaction = QTransactionsTable.transactionsTable;
    var predicate = Expressions.asBoolean(true).isTrue();

    predicate.or(qTransaction.origin.ownerId.eq(userId))
            .or(qTransaction.destination.ownerId.eq(userId));

    return predicate;
  }
}