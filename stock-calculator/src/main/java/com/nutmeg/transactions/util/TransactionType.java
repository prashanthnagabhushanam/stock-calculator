package com.nutmeg.transactions.util;

import com.nutmeg.transactions.Result;
import com.nutmeg.transactions.Transaction;

public enum TransactionType {

	BOT {
		public Result calculate(Transaction transaction) {
			return new Result(-1 * transaction.getPrice(),
					transaction.getUnit());
		}
	},

	SLD {
		public Result calculate(Transaction transaction) {
			return new Result(transaction.getPrice(), -1
					* (transaction.getUnit()));
		}
	},

	DIV {
		public Result calculate(Transaction transaction) {
			return new Result(transaction.getPrice(), 0);
		}
	},

	DEP {
		public Result calculate(Transaction transaction) {
			return new Result(transaction.getPrice(), 0);
		}
	},

	WDR {
		public Result calculate(Transaction transaction) {
			return new Result(-1 * transaction.getPrice(), 0);
		}
	};

	public abstract Result calculate(Transaction transaction);
}
