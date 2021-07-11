    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) result[i] = 1;
    int left = 1, right = 1;
    for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
        left *= nums[i];
        right *= nums[j];
        result[i + 1] *= left;
        result[j - 1] *= right;
    }
    return result;