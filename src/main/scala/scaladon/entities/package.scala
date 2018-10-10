package scaladon

import java.net.{URI, URL}
import java.time.ZonedDateTime

import enumeratum.EnumEntry.Lowercase
import enumeratum._

/**
  * These are REST entities, so the names of the case class parameters use snake_case instead of
  * camelCase so that the automatic json codec derivation will map the expected json
  */
package object entities {

  case class EntityId[T](id: Long)

  type AccountId = EntityId[Account]

  case class Account(
    id: AccountId,
    username: String,
    acct: String,
    display_name: String,
    locked: Boolean,
    created_at: ZonedDateTime,
    followers_count: Int,
    following_count: Int,
    statuses_count: Int,
    note: String,
    url: URL,
    avatar: URL,
    avatar_static: URL,
    header: URL,
    header_static: URL,
    emojis: List[Emoji],
    moved: Option[String],
    fields: Option[Map[String, String]],
    bot: Option[Boolean]
  )

  case class Application(name: String, website: Option[URL])

  type AttachmentId = EntityId[Attachment]
  case class Attachment(
    id: AttachmentId,
    `type`: String,
    url: URL,
    remote_url: Option[URL],
    preview_url: URL,
    text_url: Option[URL],
    meta: Option[Map[String, Object]],
    description: Option[String]
  )

  type OEmbedData = String

  case class Card(
    url: URL,
    title: String,
    description: String,
    image: Option[URL],
    `type`: String,
    author_name: Option[OEmbedData],
    author_url: Option[OEmbedData],
    provider_name: Option[OEmbedData],
    provider_url: Option[OEmbedData],
    html: Option[OEmbedData],
    width: Option[OEmbedData],
    height: Option[OEmbedData],
  )

  case class Context(ancestors: List[Status], descendents: List[Status])

  case class Emoji(shortcode: String, static_url: String, url: URL, visible_in_picker: String)

  case class Error(error: String)

  type FilterId = EntityId[Filter]
  case class Filter(id: FilterId, phrase: String, context: String, expires_at: Option[ZonedDateTime], irreversible: Boolean, whole_word: Boolean)

  case class Instance(
    uri: URI,
    title: String,
    description: String,
    email: String,
    version: String,
    //urls:streamingAPI,
    languages: List[String],
    contact_account: Account
  )

  // Know as `List` in Mastodon - renamed here for obvious reasons
  type MembershipListId = EntityId[MembershipList]
  case class MembershipList(id: MembershipListId, title: String)

  case class Mention(URL: URL, username: String, acct: String, id: AccountId)

  type NotificationId = EntityId[Notification]
  case class Notification(id: NotificationId, _type: String, createdAt: ZonedDateTime, account: AccountId, status: Option[StatusId])

  type PushSubscriptionId = EntityId[PushSubscription]
  case class PushSubscription(id: PushSubscriptionId, endpoint: URL, serverKey: String, alerts: Map[String, Boolean])

  case class Relationship(
    id: AccountId,
    following: Boolean,
    followedBy: Boolean,
    blocking: Boolean,
    muting: Boolean,
    muting_notifications: Boolean,
    requested: Boolean,
    domain_blocking: Boolean,
    showing_reblogs: Boolean,
    endorsed: Boolean
  )

  type ReportId = EntityId[Report]
  case class Report(id: ReportId, action_taken: String)

  case class Results(accounts: List[Account], statuses: List[Status], hashtags: List[String])

  sealed trait Visibility extends EnumEntry with Lowercase

  object Visibility extends Enum[Visibility] {
    //noinspection TypeAnnotation
    val values = findValues

    case object Public extends Visibility
    case object Unlisted extends Visibility
    case object Private extends Visibility
    case object Direct extends Visibility
  }

  type StatusId = EntityId[Status]
  case class Status(
    id: StatusId,
    uri: URI,
    url: Option[URL],
    account: Account,
    in_reply_to_id: Option[StatusId],
    in_reply_to_account_id: Option[AccountId],
    reblog: Option[Status],
    content: String,
    created_at: ZonedDateTime,
    emojis: List[Emoji],
    replies_count: Int,
    reblogs_count: Int,
    favourites_count: Int,
    reblogged: Option[Boolean],
    favourited: Option[Boolean],
    muted: Option[Boolean],
    sensitive: Boolean,
    spoiler_text: String,
    visibility: Visibility,
    media_attachments: List[Attachment],
    mentions: List[Mention],
    tags: List[Tag],
    application: Option[Application],
    language: Option[String],
    pinned: Option[Boolean]
  )

  case class TagUsage(day: Long, uses: Long, accounts: Long)
  case class Tag(name: String, url: URL, history: Option[List[TagUsage]])

}
