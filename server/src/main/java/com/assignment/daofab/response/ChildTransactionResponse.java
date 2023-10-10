package com.assignment.daofab.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ChildTransactionResponse implements Comparable<ChildTransactionResponse>{
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long paidAmount;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChildTransactionResponse that = (ChildTransactionResponse) o;
		return id == that.id && totalAmount == that.totalAmount && paidAmount == that.paidAmount && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public int compareTo(ChildTransactionResponse o) {
		return Long.compare(this.getId(), o.getId());
	}
}
