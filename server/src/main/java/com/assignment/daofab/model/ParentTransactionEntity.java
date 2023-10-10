package com.assignment.daofab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@Getter
@Setter
public class ParentTransactionEntity {
	long id;
	String sender;
	String receiver;
	long totalAmount;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParentTransactionEntity that = (ParentTransactionEntity) o;
		return id == that.id && totalAmount == that.totalAmount && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sender, receiver, totalAmount);
	}
}
