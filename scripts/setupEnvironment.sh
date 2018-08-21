#!/usr/bin/env bash

# Exit script if you try to use an uninitialized variable.
set -o nounset

# Exit script if a statement returns a non-true return value.
set -o errexit

# Use the error status of the first failure, rather than that of the last item in a pipeline.
set -o pipefail

ROOT_DIR="$(git rev-parse --show-toplevel)"
CURR_DIR="$PWD"
GIT_ROOT="$(git rev-parse --git-dir)"

echo "Setting up environment for $ROOT_DIR"

ln -s -f "$CURR_DIR/enforceBranchName.sh" "$GIT_ROOT/hooks/pre-commit"

ln -s -f "$CURR_DIR/enforceJiraTicketNumberInCommitMessage.sh" "$GIT_ROOT/hooks/commit-msg"

cp "$CURR_DIR/editorconfig" "$ROOT_DIR/.editorconfig"