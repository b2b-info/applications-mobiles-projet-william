package ca.qc.bdeb.a17.myapplication.API

data class BookList(
    val numFound: Int,
    val start: Int,
    val numFoundExact: Boolean,
    val docs: List<Docs>
)