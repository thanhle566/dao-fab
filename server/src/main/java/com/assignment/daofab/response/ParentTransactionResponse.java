package com.assignment.daofab.response;

import lombok.*;

import java.util.Objects;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ParentTransactionResponse implements Comparable<ParentTransactionResponse>{
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long totalPaidAmount;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParentTransactionResponse that = (ParentTransactionResponse) o;
		return id == that.id && totalAmount == that.totalAmount && totalPaidAmount == that.totalPaidAmount && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sender, receiver, totalAmount, totalPaidAmount);
	}

	@Override
	public int compareTo(ParentTransactionResponse o) {
		return Long.compare(this.getId(), o.getId());
	}
}
