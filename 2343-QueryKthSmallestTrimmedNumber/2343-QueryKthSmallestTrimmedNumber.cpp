    // Step 1: Create a vector to store the original indices and the trimmed numbers
    vector<pair<string, int>> trimmedNumbers;

    for (int i = 0; i < n; ++i) {
        string trimmed = nums[i].substr(m - 1, 1);  // Trim to the last digit
        trimmedNumbers.push_back({trimmed, i});
    }

    // Step 2: Sort the trimmedNumbers vector based on the trimmed numbers and original indices
    sort(trimmedNumbers.begin(), trimmedNumbers.end());

    // Step 3: Process each query and find the kth smallest trimmed number in nums
    for (const auto& query : queries) {
        int k = query[0];
        int trim = query[1];

        // Step 3a: Trim each number in nums to its rightmost trim digits
        for (int i = 0; i < n; ++i) {
            int startPos = max(0, m - trim);  // Ensure that the starting position is non-negative
            int subLength = min(trim, m - startPos);  // Ensure that the length is within bounds

            nums[i] = nums[i].substr(startPos, subLength);
        }


        // Step 3b: Determine the index of the kth smallest trimmed number in nums
        string kthSmallest = trimmedNumbers[k - 1].first;

        // Find the index of the kth smallest trimmed number in the sorted trimmedNumbers vector
        int index = lower_bound(trimmedNumbers.begin(), trimmedNumbers.end(), make_pair(kthSmallest, 0)) - trimmedNumbers.begin();

        // Reset each number in nums to its original length
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i].substr(0, m);
        }

        // Step 3c: Store the answer in the result vector
        answer.push_back(trimmedNumbers[index].second);
    }
    return answer;
} 