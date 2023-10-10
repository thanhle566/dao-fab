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
public class ChildTransactionEntity {
	long id;
	long parentId;
	long paidAmount;

	public Long getParentId() {
		return parentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ChildTransactionEntity that = (ChildTransactionEntity) o;
		return id == that.id && parentId == that.parentId && paidAmount == that.paidAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, parentId, paidAmount);
	}
}
