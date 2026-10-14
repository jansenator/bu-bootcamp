# BU CS Foundations Bootcamp

This respository is for the Bootcamp part of the Software Engineering for AI degree program. Each module folder contains coding exercises for that module.

## Folder Structure
- module1/ : Development environment and first Java programs
- module2/ : Programming fundamentals (variables, control flow, methods, files)
- module3/ : Data structures and object-oriented basics
- module4/ : TBD
- module5/ : TBD

## Pull request protection

[`rulesets/pull-request.json`](rulesets/pull-request.json) is an importable GitHub
branch ruleset enforcing pull requests on the default branch (currently `main`).
Committing this file does **not** activate repository settings.

A repository administrator must:
1. Open [Settings → Rules → Rulesets](https://github.com/jansenator/bu-bootcamp/settings/rules).
2. Check existing rulesets to avoid creating a duplicate; update an equivalent
   ruleset to match this configuration if one already exists.
3. Otherwise, select **New ruleset → Import a ruleset** and upload
   `rulesets/pull-request.json`.
4. Confirm **Active** enforcement, the **Default branch** target, an empty bypass
   list, and the rules below, then save.

The ruleset requires one approving review from another contributor, dismisses
stale approvals when reviewable changes are pushed, and requires all review
conversations to be resolved. Direct pushes, force pushes, and branch deletion
are blocked, with no bypass actors configured (including administrators).
Exercise branches remain unrestricted. An eligible reviewer with write access
is needed before merging; authors cannot approve their own pull requests.

No status checks, code-owner reviews, signed commits, or merge queue are required:
this bootcamp repository has no checked-in CI workflows or CODEOWNERS file.
Merge methods are left unchanged. Future JSON edits must also be applied in
Settings; GitHub does not automatically synchronize this file.