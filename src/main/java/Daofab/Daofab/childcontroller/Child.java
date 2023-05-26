package Daofab.Daofab.childcontroller;

public class Child {
	
		private int id;
		private int parentId;
		private long paidAmount;
		public Child(int id, int parentId, long paidAmount) {
			super();
			this.id = id;
			this.parentId = parentId;
			this.paidAmount = paidAmount;
		}
		public Child() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		public long getPaidAmount() {
			return paidAmount;
		}
		@Override
		public String toString() {
			return "Child [id=" + id + ", parentId=" + parentId + ", paidAmount=" + paidAmount + "]";
		}
		public void setPaidAmount(long paidAmount) {
			this.paidAmount = paidAmount;
		}
	

}
