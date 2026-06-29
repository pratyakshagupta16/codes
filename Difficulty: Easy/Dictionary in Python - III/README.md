<h2><a href="https://www.geeksforgeeks.org/problems/dictionary-in-python-iii/1?page=1&category=python&sortBy=submissions">Dictionary in Python - III</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p data-start="94" data-end="152">Given <strong>N </strong>number&nbsp; of queries, implement a <strong data-start="131" data-end="145">dictionary</strong> where <strong data-start="156" data-end="163">key</strong> represents the <strong data-start="179" data-end="195">student name</strong> and <strong data-start="207" data-end="216">value</strong> represents the <strong data-start="232" data-end="251">student's marks </strong>.<br>Each query can be one of the following three types:</p>
<p data-start="94" data-end="152"><strong data-start="319" data-end="345">1- Insert (i key value):</strong><br data-start="345" data-end="348">&nbsp; &nbsp; Insert the given key with its corresponding value into the dictionary.<br data-start="425" data-end="428">&nbsp; &nbsp; The driver code will print "Inserted" after successful insertion.<br><strong data-start="505" data-end="525">2- Delete (d key):</strong><br data-start="525" data-end="528">&nbsp; &nbsp; Delete the entry corresponding to the given key from the dictionary.<br>&nbsp; &nbsp; Return True if the key exists and is deleted successfully (driver prints "Deleted").<br>&nbsp; &nbsp; Return False if the key does not exist (driver prints "-1").<br><strong data-start="780" data-end="799">3- Print (p key):<br></strong>&nbsp; &nbsp; Print the marks of the given student in the following format:<br>&nbsp; &nbsp; "Marks of &lt;student name&gt; is : &lt;marks&gt;".<br>&nbsp; &nbsp; Return True if the key exists and the marks are printed successfully.<br>&nbsp; &nbsp; Return False if the key does not exist (driver prints "-1").<br><br>Implement the following functions:<br><strong>&nbsp;insert_dict</strong>(query, dict)→ inserts a key-value pair into the dictionary.<br><strong>&nbsp;del_dict</strong>(query, dict)→ deletes a key from the dictionary and returns a boolean.<br><strong>&nbsp;print_dict</strong>(query, dict)→ prints the student's marks and returns a boolean.&nbsp;</p>
<p data-start="47" data-end="123"><strong style="font-size: 18px;">Example:</strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong></span>
<span style="font-size: 18px;">N = 5</span>
<span style="font-size: 18px;">i geeks 100</span>
<span style="font-size: 18px;">i for 200</span>
<span style="font-size: 18px;">d geeks</span>
<span style="font-size: 18px;">i geeks 300</span>
<span style="font-size: 18px;">p geeks</span>
<span style="font-size: 18px;"><strong>Output:</strong></span>
<span style="font-size: 18px;">Inserted</span>
<span style="font-size: 18px;">Inserted</span>
<span style="font-size: 18px;">Deleted</span>
<span style="font-size: 18px;">Inserted</span>
<span style="font-size: 18px;">Marks of geeks is 300</span>
<span style="font-size: 18px;"><strong>Explanation:</strong></span>
<span style="font-size: 18px;">For first four queries, insert and del operation happens, correspondingly <strong>Inserted </strong>And <strong>Deleted </strong>is printed. For the last query, marks of geeks is printed.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ N ≤ 10<sup>4</sup><br>1 ≤ marks ≤ 10<sup>4</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>python-dict</code>&nbsp;<code>python</code>&nbsp;