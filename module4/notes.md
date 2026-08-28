# What I've learned
During this module I really learned how to use GitHub than I was before.  I particularly like the wonderful cheat sheet that I printed and then used AI to create as a .md file here for my reference:

# Git Command Reference (Day-to-Day)

A compact reference of the Git commands that cover 95% of day-to-day work.

## Core Workflow

- **`git status`** — Shows what has changed since the last commit.  
  *When to use:* Before any add or commit.

- **`git add <file>`** — Stages a specific file for the next commit.  
  *When to use:* After editing files you want to commit.

- **`git add .`** — Stages all changed files in the current folder.  
  *When to use:* When you want to commit everything.

- **`git commit -m "msg"`** — Saves a snapshot with a message.  
  *When to use:* After staging the right files.

## Syncing With GitHub

- **`git push`** — Sends local commits to GitHub.  
  *When to use:* After committing, to back up and share.

- **`git pull`** — Gets new commits from GitHub to your machine.  
  *When to use:* Before starting new work; after others push.

## Reviewing History and Changes

- **`git log`** — Shows the commit history.  
  *When to use:* To review what changed and when.

- **`git log --oneline`** — Compact one line view of history.  
  *When to use:* Quick overview of recent commits.

- **`git diff`** — Shows unstaged changes line by line.  
  *When to use:* Before staging, to review your edits.

## Branching and Merging

- **`git branch`** — Lists all branches.  
  *When to use:* To see what branches exist.

- **`git checkout -b name`** — Creates and switches to a new branch.  
  *When to use:* When starting a new feature or fix.

- **`git checkout main`** — Switches back to the main branch.  
  *When to use:* After finishing work on a branch.

- **`git merge <branch>`** — Merges a branch into the current branch.  
  *When to use:* After completing work on a feature branch.

## Setup

- **`git clone <url>`** — Copies a GitHub repository to your machine.  
  *When to use:* Once, when first setting up a project.