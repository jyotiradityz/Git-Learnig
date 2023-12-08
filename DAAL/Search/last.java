class last {

static class Node {
	int data;
	Node left, right;
	int leftSize;
}

static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = null;
	temp.right = null;
	temp.leftSize = 0;
	return temp;
}

// Inserting a new Node.
static Node insert(Node root, int data)
{
	if (root == null)
		return newNode(data);

	// Updating size of left subtree.
	if (data <= root.data) {
		root.left = insert(root.left, data);
		root.leftSize++;
	}
	else
		root.right = insert(root.right, data);

	return root;
}
static int getRank(Node root, int x)
{
	
	if (root.data == x)
		return root.leftSize;

	
	if (x < root.data) {
		if (root.left == null)
			return -1;
		else
			return getRank(root.left, x);
	}

	
	else {
		if (root.right == null)
			return -1;
		else {
			int rightSize = getRank(root.right, x);
		if(rightSize == -1) return -1;
			return root.leftSize + 1 + rightSize;
		}
	}
}

public static void main(String[] args)
{
	int arr[] = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
	int n = arr.length;
	int x = 4;

	Node root = null;
	for (int i = 0; i < n; i++)
		root = insert(root, arr[i]);

	System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

	x = 13;
	System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

}
}
