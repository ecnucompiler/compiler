" Vim syntax file
" Language: BP boolean program in project of compiler course
" Maintainer: ned_chu

" If .bp is defined then exit
if exists("b:current_syntax")
  finish
endif

" define syntax
" Macro keyword
syn keyword bpDefine define

" Declare keyword
syn keyword bpDecl global local

" Constant 0 1 & star
syn match bpConst "\<0\|\<1\|\*"

" Binary Operator
syn match bpBiop "[\&\|\^\!\=\<\>]\|\-\-"

" Brace
syn match bpBrace "(\|)"

" String
syn region bpString start=/"/ skip=/\\"/ end=/"/

" Stack
syn region bpStack start=/</ skip=/\\</ end=/>/

" Comment
syn region bpCommentL start="//" skip="\\$" end="$"
syn region bpCommentB start="/\*" end="\*/"

" Link defined pattern to system pattern
hi def link bpDecl Type
hi def link bpConst Constant
hi def link bpDefine Macro
hi def link bpBiop Operator
hi def link bpString String
hi def link bpStack SpecialChar
hi def link bpBrace SpecialChar
hi def link bpCommentL Comment
hi def link bpCommentB Comment

let b:current_syntax = "bpp"
