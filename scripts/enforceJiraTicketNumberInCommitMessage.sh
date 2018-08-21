#!/usr/bin/env bash

COMMIT_FILE=$1
COMMIT_MSG=$(cat "$1")
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
JIRA_ID=$(printf "%s" "$CURRENT_BRANCH" | grep -Eo "[A-Z0-9]{1,10}-?[A-Z0-9]+-\d+")

# If commit message is a fixup message, ignore it
if printf "%s" "$COMMIT_MSG" | grep 'fixup!'; then
  FIXUP="YES"
fi

# If the commit message already has JIRA id, ignore it
if printf "%s" "$COMMIT_MSG" | grep "${JIRA_ID}"; then
  HAS_JIRA="YES"
fi

if [ ! -z "$JIRA_ID" ] && [ -z "${FIXUP}" ] && [ -z "${HAS_JIRA}" ]; then
    printf "%s\n\nJIRA:\n%s" "$COMMIT_MSG" "$JIRA_ID" > "$COMMIT_FILE"
    printf "JIRA ID %s, matched in current branch name, appending to commit message. (Use --no-verify to skip)" "$JIRA_ID"
fi
