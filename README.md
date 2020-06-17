# PasswordValidator
Passwords in important software are analyzed based on the following criteria:
1. Minimum length of 8 characters
2. Not more than 16 characters
3. At least one upper case
4. At least one lower case
5. At least one numeric character
6. At least one special character (other than space)
7. More than 2 Upper-case or lower-case characters do not appear consecutively
8. Consecutive numbers are not used

This program takes input as password and categorize them into ‘invalid’ (0), ‘weak’(1), ‘medium’(2) and ‘strong’ (3) passwords based on the following conditions:

Invalid: Less than 2 password criteria are followed<br>
Weak: At least 2 password criteria are followed<br>
Medium: At least 5 password criteria are followed<br>
Strong: All password criteria are used.<br>
